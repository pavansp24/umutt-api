package org.umutt.spring.verticle;

import static java.net.HttpURLConnection.HTTP_CREATED;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.serviceproxy.ProxyHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.umutt.dto.LoginRequest;
import org.umutt.dto.RegistrationDto;
import org.umutt.dto.RegistrationDtoConverter;
import org.umutt.dto.UserDtoConverter;
import org.umutt.spring.service.UmuttAsyncService;

@Component
public class UmuttRestVerticle extends AbstractVerticle {

	private static Logger LOGGER = LoggerFactory
			.getLogger(UmuttRestVerticle.class);

	private UmuttAsyncService asyncService;

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		LOGGER.info("Started deploying the umutt worker verticle");

		asyncService = ProxyHelper.createProxy(UmuttAsyncService.class, vertx,
				UmuttAsyncService.ADDRESS);

		Router router = Router.router(vertx);
		router.route().handler(BodyHandler.create());

		router.route("/").handler(
				res -> {
					res.response().putHeader("Content-Type", "text/html")
							.setChunked(true).setStatusCode(200)
							.end("Welcome to Umutt Services!!");
				});

		router.post("/login").handler(this::login);
		router.post("/donors").handler(this::addDonor);
		router.get("/donors").handler(this::listDonors);

		StaticHandler staticHandler = StaticHandler.create();
		router.route().handler(staticHandler);

		vertx.createHttpServer().requestHandler(router::accept)
				.listen(8080, res -> {
					if (res.succeeded()) {
						startFuture.complete();
					} else {
						startFuture.fail(res.cause());
					}
				});

		LOGGER.info("Completed deploying the umutt worker verticle");

	}

	private void addDonor(RoutingContext routingContext) {
		RegistrationDto registrationDto = new RegistrationDto(
				routingContext.getBodyAsJson());
		asyncService.register(registrationDto,
				ar -> {
					if (ar.succeeded()) {
						JsonObject json = new JsonObject();
						RegistrationDtoConverter.toJson(ar.result(), json);
						routingContext.response().setStatusCode(HTTP_CREATED)
								.end(json.encodePrettily());
					} else {
						routingContext.fail(ar.cause());
					}
				});
	}

	private void listDonors(RoutingContext routingContext) {

		String userId = routingContext.request().getParam("volunteerID");
		asyncService.list(
				userId,
				res -> {
					if (res.succeeded()) {
						JsonArray jsonArray = new JsonArray(res.result());
						routingContext.response().setStatusCode(200)
								.end(jsonArray.encodePrettily());
					} else {
						routingContext.fail(res.cause());
					}
				});
	}

	private void login(RoutingContext routingContext) {
		LoginRequest loginRequest = new LoginRequest(
				routingContext.getBodyAsJson());
		asyncService.getUser(
				loginRequest,
				ar -> {
					if (ar.succeeded()) {
						if (null == ar.result()) {
							routingContext.response().setStatusCode(401)
									.setStatusMessage("Unauthorized User")
									.end();
							// routingContext.fail(new
							// ForbiddenException("Unauthorized User",401));
						} else {
							JsonObject json = new JsonObject();
							UserDtoConverter.toJson(ar.result(), json);
							routingContext.response().setStatusCode(200)
									.end(json.encodePrettily());
						}
					} else {
						routingContext.fail(ar.cause());
					}
				});
	}
}

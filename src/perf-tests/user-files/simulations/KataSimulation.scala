import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class KataSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://api:9000")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers = Map("Upgrade-Insecure-Requests" -> "1")
	val scn = scenario("KataSimulation")
		.exec(http("request_toto")
			.get("/first/toto")
			.headers(headers))
		.exec(http("request_tata")
			.get("/first/tata")
			.headers(headers))
		.exec(http("request_azertyuiop")
			.get("/first/azertyuiop")
			.headers(headers))

	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}
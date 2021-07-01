/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.agentsfrontend.controllers

import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.agentsfrontend.views.html.{ErrorTemplate, Index}
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController

import javax.inject.Inject

class DashBoardController @Inject()( mcc: MessagesControllerComponents,
                                     indexPage: Index)
  extends FrontendController(mcc) {

  val index: Action[AnyContent] = Action { implicit request =>
    request.session.get("isLoggedIn") match {
      case Some(_) => Ok(indexPage(request.session.get("arn").getOrElse("ARN Not found")))
      case _ => Redirect(routes.AgentLoginController.agentLogin())
    }
  }
}

//if(request.session.get("isLoggedIn").getOrElse("") == "true") {
//  val arn = request.session.get("arn").get
//  Ok(indexPage(arn))
//}
//  else {
//  Ok(errorPage("You are not logged in, you can't access this page!","",""))
//}
//}
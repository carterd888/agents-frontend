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

import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.agentsfrontend.views.html.{Home, InputClientCode}

import javax.inject.{Inject, Singleton}

@Singleton
class InputClientCodeController @Inject()(     mcc: MessagesControllerComponents,
                                               clientCode: InputClientCode)
  extends FrontendController(mcc) {

  val inputClientCode = Action { implicit request =>
    Ok(clientCode())
  }

  //  def submitClientCode() = Action { implicit request =>
  //    InputClientCode.form.bindFromRequest().fold(
  //      formWithErrors => BadRequest(views.html.inputClientCode(formWithErrors)),
  //      success =>  Redirect(controllers.routes.inputClientCodeController.colourForm()).withSession(request.session + ("code" -> s"${success.clientCode}"))
  //    )
  //  }
}
//case class InputClientCode(code: String)
//object InputClientCode {
//
//  val form: Form[InputClientCode] = Form(
//    mapping(
//      "code" -> text
//    )(InputClientCode.apply)(InputClientCode.unapply)
//  )
//}
//}

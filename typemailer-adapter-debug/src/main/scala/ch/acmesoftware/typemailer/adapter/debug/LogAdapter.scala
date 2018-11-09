package ch.acmesoftware.typemailer.adapter.debug

import ch.acmesoftware.typemailer.core.{Mail, SenderAdapter}
import org.slf4j.Logger

case class LogAdapter(logger: Logger) extends SenderAdapter {

  override def sendEffect(message: Mail): Unit = logger.debug(
    s"""Sending email
       |  from ${message._from}
       |  to ${message._to.mkString(", ")}
       |  with cc: ${message._cc.mkString(", ")}
       |  with ccc: ${message._bcc.mkString(", ")}
       |  subject: ${message._subject.getOrElse("")}
       |  html: ${message._html.getOrElse("")}
       |  text: ${message._text.getOrElse("")}
     """.stripMargin)

}

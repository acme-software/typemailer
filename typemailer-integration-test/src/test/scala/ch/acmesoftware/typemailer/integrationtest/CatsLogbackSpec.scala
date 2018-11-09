package ch.acmesoftware.typemailer.integrationtest

import ch.acmesoftware.typemailer.adapter.debug.LogAdapter
import ch.acmesoftware.typemailer.catseffect._
import ch.acmesoftware.typemailer.core.Mail
import org.scalatest.{FlatSpec, Matchers}
import org.slf4j.LoggerFactory

class CatsLogbackSpec extends FlatSpec with Matchers {

  "slf4j adapter" should "log sent messages" in {

    for {
      sender <- Sender(LogAdapter(LoggerFactory.getLogger("test")))
      mail <- Mail.
        from("test@typemailer.acmesoftware.ch").
        to("recepient1@typemailer.acmesoftware.ch").
        to("recepient2@typemailer.acmesoftware.ch").
        subject("Test Subject").
        pureIO
      _ <- sender.send(mail)
    } yield ()
  }
}

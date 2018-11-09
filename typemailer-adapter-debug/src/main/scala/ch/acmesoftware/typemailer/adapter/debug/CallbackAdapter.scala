package ch.acmesoftware.typemailer.adapter.debug

import ch.acmesoftware.typemailer.core.{Mail, SenderAdapter}

case class CallbackAdapter(callback: Mail => Unit) extends SenderAdapter {

  override def sendEffect(message: Mail): Unit = callback(message)
}

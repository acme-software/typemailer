package ch.acmesoftware.typemailer.core

trait SenderAdapter {
  def sendEffect(message: Mail): Unit
}

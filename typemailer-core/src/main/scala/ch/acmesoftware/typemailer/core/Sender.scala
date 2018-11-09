package ch.acmesoftware.typemailer.core

import scala.language.higherKinds

trait Sender[F[_]] {

  def send(email: Mail): F[Unit]

}


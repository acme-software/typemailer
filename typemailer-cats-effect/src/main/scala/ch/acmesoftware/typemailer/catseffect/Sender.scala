package ch.acmesoftware.typemailer.catseffect

import cats.data._
import cats.effect.IO
import cats.syntax.all._
import ch.acmesoftware.typemailer.core
import ch.acmesoftware.typemailer.core.{Mail, SenderAdapter}

class Sender(adapters: NonEmptyList[SenderAdapter]) extends core.Sender[IO] {

  override def send(email: Mail): IO[Unit] = adapters.map(a => IO(a.sendEffect(email))).fold
}

object Sender {
  def apply(adapter: SenderAdapter): IO[Sender] = IO {
    new Sender(NonEmptyList.of(adapter))
  }
}
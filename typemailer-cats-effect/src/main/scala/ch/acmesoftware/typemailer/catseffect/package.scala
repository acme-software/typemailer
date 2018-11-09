package ch.acmesoftware.typemailer

import cats.Monoid
import cats.effect.IO
import ch.acmesoftware.typemailer.core.Mail

package object catseffect {

  implicit val ioUnitMonoid = new Monoid[IO[Unit]] {
    override def empty: IO[Unit] = IO.pure(())

    override def combine(x: IO[Unit], y: IO[Unit]): IO[Unit] = for {
      _ <- x
      _ <- y
    } yield ()
  }

  implicit class MailOps(mail: Mail) {
    def pureIO: IO[Mail] = IO.pure(mail)
  }
}

TypeMailer - An E-Mail Library for Scala with multiple Backends
===============================================================

[![Build Status](https://travis-ci.org/acme-software/typemailer.svg?branch=master)](https://travis-ci.org/acme-software/typemailer) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/366e9d2e21d54e309cc61c924934948a)](https://www.codacy.com/app/frne/typemailer?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=acme-software/typemailer&amp;utm_campaign=Badge_Grade)

**This is absolutely work-in-progress and by no means production-ready**

Features
--------

- Generic mailing lib for multiple backends:
  - SMTP (TODO)
  - MailGun (TODO)
  - Slf4J
  - Filesystem (TODO)
  - Callback (debug)
- Tagless final API to use with any IO monad
  - Reference implementation with cats-effect
  - More to follow

*In the examples, the cats-effect IO monad is used*
  
Usage
-----

The library is splitted in senders and receivers, because some backends (e.g. mailgun) can only send. YOu can use 
different backends for sending and receiving.

Every sender / receiver needs a concrete adapter implementation, which is specific by backend. In the following examples, 
the `LogAdapter`, which just logs every sent mail with SLF4J, is used:

```scala
import ch.acmesoftware.typemailer.adapter.debug.LogAdapter
import ch.acmesoftware.typemailer.catseffect._
import ch.acmesoftware.typemailer.core.Mail
import org.slf4j.LoggerFactory

val sendMail = for {
  sender <- Sender(LogAdapter(LoggerFactory.getLogger("test")))
  mail <- Mail.
    from("test@typemailer.acmesoftware.ch").
    to("recepient1@typemailer.acmesoftware.ch").
    to("recepient2@typemailer.acmesoftware.ch").
    subject("Test Subject").
    pureIO
  _ <- sender.send(mail)
} yield ()

sendMail.unsafeRunSync
```

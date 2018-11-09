package ch.acmesoftware.typemailer.core

case class Mail(_from: String,
                _to: List[String],
                _cc: List[String],
                _bcc: List[String],
                _subject: Option[String],
                _text: Option[String],
                _html: Option[String]) {

  def to(toNew: String): Mail = copy(_to = _to :+ toNew)

  def subject(sub: String): Mail = copy(_subject = Some(sub))
}


object Mail {
  def from(from: String): Mail = new Mail(from, Nil, Nil, Nil, None, None, None)
}

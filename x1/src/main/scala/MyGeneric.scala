package example

import kantan.csv.RowEncoder
import kantan.csv.CellEncoder
import shapeless.{::, Generic, HList, HNil, Lazy}

object MyGeneric {
  implicit val nil: MyEncoder[HNil] =
    MyEncoder(_ => Nil)

  implicit def cons[H: CellEncoder, T <: HList: MyEncoder]: MyEncoder[H :: T] =
    MyEncoder { case h :: t =>
      CellEncoder[H].encode(h) +: implicitly[MyEncoder[T]].f(t)
    }

  implicit def product[A, L <: HList](implicit
      gen: Generic.Aux[A, L],
      hlist: Lazy[MyEncoder[L]]
  ): RowEncoder[A] = RowEncoder.from(a => hlist.value.f(gen.to(a)))

  case class MyEncoder[A](f: A => Seq[String])
}

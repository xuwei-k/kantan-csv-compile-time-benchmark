package example

import kantan.codecs.Encoder
import kantan.codecs.export.DerivedEncoder
import shapeless.HList
import shapeless.LabelledGeneric
import shapeless.Lazy

object MyOverrideGeneric extends kantan.csv.generic.GenericInstances {
  override def caseClassEncoderFromLabelled[E, D, T, H <: HList](implicit
      generic: LabelledGeneric.Aux[D, H],
      hEncoder: Lazy[Encoder[E, H, T]]
  ): DerivedEncoder[E, D, T] = ???
}

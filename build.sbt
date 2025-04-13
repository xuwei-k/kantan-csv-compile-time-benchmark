val common = Def.settings(
  scalaVersion := "2.13.16",
  libraryDependencies += "com.nrinaudo" %% "kantan.csv-generic" % "0.8.0"
)

val x1 = project.settings(common)

def gen(imports: String) = {
  Compile / sourceGenerators += task {
    val dir = (Compile / sourceManaged).value
    (1 to 16).map { n =>
      val methods = (1 to 16)
        .map { i =>
          s"  def f${i} = implicitly[kantan.csv.RowEncoder[A1]]"
        }
        .mkString("\n")
      val src =
        s"""|package example
            |
            |$imports
            |
            |class Y${n} {
            |$methods
            |}
            |""".stripMargin
      val f = dir / s"Y${n}.scala"
      IO.write(f, src)
      f
    }
  }
}

val a1 = project
  .settings(
    common,
    gen(
      Seq(
        "import example.MyOverrideGeneric._"
      ).mkString("\n")
    )
  )
  .dependsOn(x1)

package com.stackoverflow.question

import com.stackoverflow.module.{ ModuleConfig, ModuleConfiguration }
import com.typesafe.config.{ Config, ConfigFactory }
import net.ceedubs.ficus.Ficus._

object AppConfig extends AppConfig

trait AppConfig extends ModuleConfig {

  def config: Config = ConfigFactory.load()
  def conn = config.as[ModuleConfiguration]("stackoverflow.conn")

  val name = config.as[String]("stackoverflow.name")
}

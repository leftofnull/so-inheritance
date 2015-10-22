package com.stackoverflow.question

import com.stackoverflow.module.{ ModuleConfig, ModuleConfiguration }
import com.typesafe.config.{ Config, ConfigFactory }
import net.ceedubs.ficus.Ficus._

object AppConfig extends AppConfig

trait AppConfig extends ModuleConfig {

  val config: Config = ConfigFactory.load()
  def conn = config.as[ModuleConfiguration]("stackoverflow.conn")

  def name = config.as[String]("stackoverflow.name")
}

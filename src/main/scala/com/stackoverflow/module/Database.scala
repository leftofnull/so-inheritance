package com.stackoverflow.module

import com.typesafe.config.{ ConfigFactory, Config }
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader

trait ModuleConfig {

  implicit val moduleConfigReader: ValueReader[ModuleConfiguration] =
    ValueReader.relative { c => ModuleConfiguration(c.as[String]("hostname")) }

  def conn: ModuleConfiguration
}

case class ModuleConfiguration(hostName: String)

trait DatabaseConnector {
  implicit val host = getHost
  def getHost: String
}

trait HostConnector extends DatabaseConnector {
  config: ModuleConfig =>

  def getHost = conn.hostName
}

trait TableFunctions {
  connector: DatabaseConnector =>

  def select: Unit = println(host)
}

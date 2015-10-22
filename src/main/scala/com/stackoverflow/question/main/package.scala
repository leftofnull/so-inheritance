package com.stackoverflow.question

import com.stackoverflow.module._
import com.stackoverflow.question.AppConfig
import com.typesafe.config.ConfigFactory

package main {
  trait DataConfig extends ModuleConfig {
    def conn = AppConfig.conn
  }

  object DatabaseService extends TableFunctions with HostConnector with DataConfig   // This works with the proxy
  object BadDatabaseService extends TableFunctions with HostConnector with AppConfig // This fails with NullPointerException, it's the ConfigFactory.load that returns null
}

package com.stackoverflow.question.main

import com.stackoverflow.question.AppConfig

object Question {
  def main(args: Array[String]) = {
    DatabaseService.select    // works
    BadDatabaseService.select // NullPointerException
  }
}

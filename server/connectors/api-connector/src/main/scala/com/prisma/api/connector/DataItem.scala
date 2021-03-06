package com.prisma.api.connector

import com.prisma.shared.models.IdType.Id

case class DataItem(id: Id, userData: Map[String, Option[Any]] = Map.empty, typeName: Option[String] = None) {
  def apply(key: String): Option[Any]      = userData(key)
  def get[T](key: String): T               = userData(key).get.asInstanceOf[T]
  def getOption[T](key: String): Option[T] = userData.get(key).flatten.map(_.asInstanceOf[T])
}

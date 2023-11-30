package com.github.hugo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@Dao
interface SoftwareDao {

    @Query("SELECT * FROM software")
    fun getAll(): List<SoftwareEntity>

    @Query("SELECT * FROM software WHERE uid in (:Ids)")
    fun loadAllByIds(Ids: IntArray): List<SoftwareEntity>

    @Query("SELECT * FROM software WHERE title LIKE :title AND url LIKE :url LIMIT 1")
    fun findByTitleUrl(title: String, url: String): SoftwareEntity

    @Insert
    fun insertAll(vararg user: SoftwareEntity)

    @Delete
    fun delete(software: SoftwareEntity)
}
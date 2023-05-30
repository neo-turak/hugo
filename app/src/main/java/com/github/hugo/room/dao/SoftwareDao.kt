package com.github.hugo.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.hugo.room.entity.SoftwareEntity

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@Dao
interface SoftwareDao {

    @Query("SELECT * FROM software")
   suspend fun getAll(): List<SoftwareEntity>

    @Query("SELECT * FROM software WHERE uid in (:Ids)")
   suspend fun loadAllByIds(Ids: IntArray): List<SoftwareEntity>

    @Query("SELECT * FROM software WHERE title LIKE :title AND url LIKE :url LIMIT 1")
    suspend fun findByTitleUrl(title: String, url: String): SoftwareEntity

    @Insert
    suspend fun insertAll(vararg user: SoftwareEntity)

    @Delete
   suspend fun delete(software: SoftwareEntity)
}
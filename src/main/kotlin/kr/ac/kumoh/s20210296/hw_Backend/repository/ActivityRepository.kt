package kr.ac.kumoh.s20210296.hw_Backend.repository

import kr.ac.kumoh.s20210296.hw_Backend.model.Activity
import org.springframework.data.mongodb.repository.MongoRepository

interface ActivityRepository : MongoRepository<Activity, String> {
    fun findByDate(date:String):List<Activity>
}
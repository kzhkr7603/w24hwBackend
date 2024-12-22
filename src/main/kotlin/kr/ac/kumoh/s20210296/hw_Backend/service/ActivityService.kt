package kr.ac.kumoh.s20210296.hw_Backend.service

import kr.ac.kumoh.s20210296.hw_Backend.model.Activity
import kr.ac.kumoh.s20210296.hw_Backend.repository.ActivityRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(private val repository: ActivityRepository) {
    fun addActivity(activity: Activity): Activity = repository.save(activity)

    fun getAllActivitys(): List<Activity> = repository.findAll()

    fun getActivityById(id: String): Activity? = repository.findById(id).orElse(null)

    fun getActivityByDate(date:String) : List<Activity> = repository.findByDate(date)

    fun updateActivity(id: String, activity: Activity): Activity? {
        val ActivityTarget = repository.findById(id)

        return if (ActivityTarget.isPresent) {
            val oldActivity = ActivityTarget.get()
            val updatedActivity = oldActivity.copy(
                date = activity.date,
                name = activity.name,
                additionalContent = activity.additionalContent
            )
            repository.save(updatedActivity)
        } else {
            null
        }
    }

    fun deleteActivity(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
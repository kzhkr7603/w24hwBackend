package kr.ac.kumoh.s20210296.hw_Backend.controller

import kr.ac.kumoh.s20210296.hw_Backend.model.Activity
import kr.ac.kumoh.s20210296.hw_Backend.service.ActivityService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["https://guryongpofutsal.netlify.app/"])
class ActivityController(private val service: ActivityService) {
    @PostMapping
    fun addActivity(@RequestBody activity: Activity): Activity = service.addActivity(activity)

    @GetMapping
    fun getAllActivitys(): List<Activity> = service.getAllActivitys()

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: String): Activity? = service.getActivityById(id)

    @GetMapping("date/{date}")
    fun getActivityByDate(@PathVariable date: String): List<Activity> = service.getActivityByDate(date)

    @PutMapping("/{id}")
    fun updateTraining(@PathVariable id: String, @RequestBody activity: Activity): Activity? = service.updateActivity(id, activity)

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: String): Map<String, String> {
        return if (service.deleteActivity(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}

package com.baseball.baseball.infrastructure

import com.baseball.baseball.domain.Game
import com.baseball.baseball.domain.Room
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class RoomRepository {
    private val rooms = mutableListOf<Room>()

    fun count() = rooms.size.toLong()

    fun save(room: Room) : Long{
        rooms.add(room)
        return count()
    }

    fun findByRoomId(roomId:Long): Room {
        return rooms
                .filter{r-> r.roomId == roomId}
                .first()
    }
}
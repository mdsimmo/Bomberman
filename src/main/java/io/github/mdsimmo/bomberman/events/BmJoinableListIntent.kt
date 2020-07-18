package io.github.mdsimmo.bomberman.events

import io.github.mdsimmo.bomberman.game.GL
import org.bukkit.Bukkit
import org.bukkit.event.HandlerList

/**
 * Called to find a listing of every joinable game
 */
class BmJoinableListIntent : BmEvent() {
    val gls = mutableSetOf<GL>()

    override fun getHandlers(): HandlerList {
        return handlerList
    }

    companion object {
        fun list(): Set<GL> {
            val e = BmJoinableListIntent()
            Bukkit.getPluginManager().callEvent(e)
            return e.gls
        }

        @JvmStatic
        val handlerList = HandlerList()
    }
}
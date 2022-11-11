package com.example.anull

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewTreeLifecycleOwner.set
import androidx.lifecycle.ViewTreeViewModelStoreOwner.set
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.reflect.Array.set
import java.util.Collections.list
import kotlin.random.Random

class ViewModel : ViewModel() {

    private val listcol =
        arrayOf(Color.RED, Color.LTGRAY, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN)

    private val _list = MutableStateFlow<MutableList<ElementModel>?>(null)
    val list: MutableStateFlow<MutableList<ElementModel>?> = _list

    init {
        startSet()
        equals()
    }

    private fun startSet() {
        val list = mutableListOf<ElementModel>()
        repeat(15) {
            list.add(ElementModel("Lox", (1..10).random(), "Помни, арабес", listcol.random()))
        }
        _list.value = list
    }

    fun equals() {
        viewModelScope.launch {
            while (true) {
                delay(2000L)
                val elements = ElementModel("Lox", (1..10).random(), "Помни, арабес", listcol.random())
                val list = _list.value?.toMutableList()
                list?.add(elements)
                _list.value = list
            }
        }
    }


    fun deleteElement(it: ElementModel) {
        val list = _list.value?.toMutableList()
        list?.remove(it)
        _list.value = list

    }
}


package robby.hermando.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
     val liveData = MutableLiveData<Result>()

    fun setHitung(panjang: String, lebar: String): LiveData<Result> {
        val p = panjang.toDouble()
        val l = lebar.toDouble()
        val tampung = p * l
        val result = Result(tampung.toString())
        liveData.postValue(result)
        return liveData
    }

    fun getHitung(): LiveData<Result> {
        return liveData
    }
}
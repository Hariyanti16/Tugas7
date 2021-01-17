package id.ac.amikom.appserba_0645.data.model

data class ActionState<T>(
    val data: T? = null,
    val message: String? = null,
    val isSuccess: Boolean = true,
    var isCosumed: Boolean = false
)
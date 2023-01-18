package com.ajcm.menuslider.usecase

import com.ajcm.menuslider.model.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class GetMenuUseCase @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    companion object {
        const val COLLECTION = "menu"
    }

    operator fun invoke(onComplete: (List<MenuItem>) -> Unit) {
        firestore.collection(COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                result.firstOrNull()?.let { snap ->
                    onComplete(
                        snap.data.map {
                            MenuItem(
                                title = it.key,
                                imageUrl = it.value.toString()
                            )
                        }
                    )
                } ?: onComplete(emptyList())
            }
            .addOnFailureListener {
                onComplete(emptyList())
            }
    }

}

package dev.alimansour.adaptive.workspace.feature.tags

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dev.alimansour.adaptive.workspace.data.SampleData
import dev.alimansour.adaptive.workspace.data.Tag

class TagsViewModel : ViewModel() {
    val tags: List<Tag> = SampleData.tags

    private val _selectedTagIds = mutableStateListOf<String>()
    val selectedTagIds: List<String> get() = _selectedTagIds

    fun toggleTag(tagId: String) {
        if (tagId in _selectedTagIds) {
            _selectedTagIds.remove(tagId)
        } else {
            _selectedTagIds.add(tagId)
        }
    }
}

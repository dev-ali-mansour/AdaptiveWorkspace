package dev.alimansour.adaptive.workspace.feature.inbox

import androidx.lifecycle.ViewModel
import dev.alimansour.adaptive.workspace.data.Email
import dev.alimansour.adaptive.workspace.data.SampleData

class InboxViewModel : ViewModel() {
    val emails: List<Email> = SampleData.emails
}

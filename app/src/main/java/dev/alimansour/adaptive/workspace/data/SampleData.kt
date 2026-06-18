package dev.alimansour.adaptive.workspace.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.automirrored.filled.TrendingUp

object SampleData {

    val emails = listOf(
        Email(
            id = "1",
            sender = "Sarah Chen",
            senderEmail = "sarah.chen@company.com",
            subject = "Q3 Revenue Report — Final Numbers",
            preview = "Hi team, please find the finalized Q3 revenue report attached...",
            body = "Hi team,\n\nPlease find the finalized Q3 revenue report attached. Key highlights:\n\n• Total revenue: \$2.4M (+12.5% QoQ)\n• New customer acquisition up 18%\n• Enterprise segment grew 22%\n\nLet's discuss in tomorrow's all-hands meeting.\n\nBest,\nSarah",
            timestamp = "10:30 AM",
            isStarred = true
        ),
        Email(
            id = "2",
            sender = "Mike Rodriguez",
            senderEmail = "mike.r@company.com",
            subject = "Sprint Planning Tomorrow — Agenda",
            preview = "Hey everyone, tomorrow's sprint planning starts at 9 AM sharp...",
            body = "Hey everyone,\n\nTomorrow's sprint planning starts at 9 AM sharp. Please come prepared with:\n\n1. Your velocity estimates for the next sprint\n2. Any blockers from the current sprint\n3. Feature prioritization suggestions\n\nRoom: Engineering Hub, 3rd floor.\n\nCheers,\nMike",
            timestamp = "9:15 AM",
            isRead = true
        ),
        Email(
            id = "3",
            sender = "Emily Watson",
            senderEmail = "emily.watson@company.com",
            subject = "New Design System Review — Compose Components",
            preview = "I've finished the first pass on the new design system...",
            body = "Hi all,\n\nI've finished the first pass on the new design system using Jetpack Compose. Here's what's included:\n\n• Button variants (primary, secondary, outlined)\n• Typography scale aligned with Material 3\n• Color tokens for light and dark themes\n• Spacing and elevation guidelines\n\nFigma link: [attached]\n\nPlease review by Friday.\n\nThanks,\nEmily",
            timestamp = "Yesterday",
            isStarred = true
        ),
        Email(
            id = "4",
            sender = "David Kim",
            senderEmail = "david.kim@company.com",
            subject = "API Integration Complete ✅",
            preview = "Good news — the REST API integration is fully complete...",
            body = "Good news — the REST API integration is fully complete and passing all tests.\n\nEndpoints ready:\n• GET /users — paginated list\n• POST /users — create new user\n• PUT /users/{id} — update user\n• DELETE /users/{id} — soft delete\n\nAll endpoints have proper error handling and rate limiting. Documentation updated in Swagger.\n\nReady for code review whenever you are.\n\n— David",
            timestamp = "Yesterday",
            isRead = true
        ),
        Email(
            id = "5",
            sender = "Lisa Thompson",
            senderEmail = "lisa.t@company.com",
            subject = "Team Offsite Confirmed — July 15-17",
            preview = "Great news! The team offsite has been confirmed for July 15-17...",
            body = "Great news! The team offsite has been confirmed for July 15-17 at the Mountain View campus.\n\nSchedule highlights:\n• Day 1: Team building + strategy workshop\n• Day 2: Hackathon + innovation day\n• Day 3: Retrospective + planning\n\nTravel and accommodation details will follow next week. Please confirm your attendance by Friday.\n\nExciting times ahead!\n— Lisa",
            timestamp = "Monday"
        ),
        Email(
            id = "6",
            sender = "James Parker",
            senderEmail = "james.parker@company.com",
            subject = "Client Meeting Notes — Acme Corp",
            preview = "Attached are the notes from today's meeting with Acme Corp...",
            body = "Hi team,\n\nAttached are the notes from today's meeting with Acme Corp. Key takeaways:\n\n• They want to expand their current plan to Enterprise tier\n• Integration timeline: 6 weeks\n• Budget approved for Q4\n• Main concern: data migration from legacy system\n\nAction items assigned in the doc. Please review your tasks.\n\nRegards,\nJames",
            timestamp = "Monday",
            isRead = true
        ),
        Email(
            id = "7",
            sender = "Anna Kowalski",
            senderEmail = "anna.k@company.com",
            subject = "Bug Fix: Dashboard Charts Not Rendering",
            preview = "Fixed the dashboard chart rendering issue on tablets...",
            body = "Hey team,\n\nI've pushed a fix for the dashboard chart rendering issue on tablets. The root cause was a missing constraint calculation in the Grid layout.\n\nChanges:\n• Updated ChartWidget to use fractional units\n• Fixed column span calculation for wide screens\n• Added preview for tablet form factor\n\nPR: #1247 — please review.\n\nThanks,\nAnna",
            timestamp = "Last week",
            isRead = true
        ),
        Email(
            id = "8",
            sender = "Robert Chen",
            senderEmail = "robert.c@company.com",
            subject = "Weekly Standup Summary — Week 24",
            preview = "Here's the summary from this week's standups...",
            body = "Here's the summary from this week's standups:\n\nCompleted:\n• User authentication flow redesign\n• Performance optimization for list views\n• Accessibility audit — 95% compliance\n\nIn Progress:\n• Adaptive layout implementation\n• Dark theme refinements\n• Navigation 3 migration\n\nBlocked:\n• Waiting for API docs from backend team\n\n— Robert",
            timestamp = "Last week",
            isRead = true
        ),
        Email(
            id = "9",
            sender = "Maria Garcia",
            senderEmail = "maria.g@company.com",
            subject = "Product Launch Timeline — v2.0",
            preview = "The product launch timeline for v2.0 has been finalized...",
            body = "Hi everyone,\n\nThe product launch timeline for v2.0 has been finalized:\n\n• Alpha: July 1\n• Beta: August 15\n• RC: September 1\n• GA: September 15\n\nFeature freeze is July 25. All new features must be merged by then.\n\nPlease flag any risks to your team lead by this Friday.\n\nBest,\nMaria",
            timestamp = "Last week",
            isStarred = true
        ),
        Email(
            id = "10",
            sender = "Tom Wilson",
            senderEmail = "tom.w@company.com",
            subject = "Security Audit Results — All Clear",
            preview = "The annual security audit is complete. Good news overall...",
            body = "The annual security audit is complete. Results summary:\n\n✅ No critical vulnerabilities found\n✅ All encryption standards up to date\n✅ Access controls properly configured\n⚠️ 2 low-severity findings (detailed in report)\n\nThe low-severity items have a 30-day remediation window. I've created tickets for both.\n\nFull report: [attached]\n\n— Tom",
            timestamp = "2 weeks ago",
            isRead = true
        )
    )

    val dashboardStats = listOf(
        DashboardStat(
            title = "Revenue",
            value = "\$2.4M",
            change = "+12.5%",
            isPositive = true,
            icon = Icons.Default.AttachMoney
        ),
        DashboardStat(
            title = "Active Users",
            value = "18.2K",
            change = "+8.3%",
            isPositive = true,
            icon = Icons.Default.People
        ),
        DashboardStat(
            title = "Conversion",
            value = "3.2%",
            change = "-0.4%",
            isPositive = false,
            icon = Icons.AutoMirrored.Filled.TrendingUp
        ),
        DashboardStat(
            title = "Avg Response",
            value = "142ms",
            change = "-18.7%",
            isPositive = true,
            icon = Icons.Default.Speed
        )
    )

    /** Weekly chart data (Mon–Sun revenue in millions). */
    val chartData = listOf(0.7f, 0.85f, 0.6f, 0.95f, 1.1f, 0.5f, 0.4f)
    val chartLabels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    val tags = listOf(
        Tag("1", "Android", "Platform"),
        Tag("2", "Compose", "Framework"),
        Tag("3", "Kotlin", "Language"),
        Tag("4", "Material 3", "Design"),
        Tag("5", "FlexBox", "Layout"),
        Tag("6", "Grid", "Layout"),
        Tag("7", "Adaptive", "Pattern"),
        Tag("8", "Navigation 3", "Architecture"),
        Tag("9", "KMP", "Platform"),
        Tag("10", "CMP", "Platform"),
        Tag("11", "Foldable", "Form Factor"),
        Tag("12", "Tablet", "Form Factor"),
        Tag("13", "Window Size Class", "API"),
        Tag("14", "Edge-to-Edge", "UI"),
        Tag("15", "Dark Mode", "Theme"),
        Tag("16", "Accessibility", "Quality"),
    )
}

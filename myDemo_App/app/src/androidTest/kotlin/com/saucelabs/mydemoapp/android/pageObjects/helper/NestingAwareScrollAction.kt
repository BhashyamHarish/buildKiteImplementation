package com.saucelabs.mydemoapp.android.pageObjects.helper

import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf
import org.hamcrest.core.AnyOf

/**
 * Scroll action for nested scrollables
 */
class NestingAwareScrollAction : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return AllOf.allOf(
            ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
            ViewMatchers.isDescendantOfA(
                AnyOf.anyOf(
                    ViewMatchers.isAssignableFrom(ScrollView::class.java),
                    ViewMatchers.isAssignableFrom(HorizontalScrollView::class.java),
                    ViewMatchers.isAssignableFrom(NestedScrollView::class.java)
                )
            )
        )
    }
    override fun getDescription(): String? {
        return null
    }
    override fun perform(uiController: UiController, view: View) {
        ScrollToAction().perform(uiController, view)
    }
}

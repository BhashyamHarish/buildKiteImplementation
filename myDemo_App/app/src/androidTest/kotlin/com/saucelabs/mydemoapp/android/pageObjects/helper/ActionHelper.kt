package com.saucelabs.mydemoapp.android.pageObjects.helper
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.saucelabs.mydemoapp.android.utils.Logger
import junit.framework.AssertionFailedError
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.hamcrest.TypeSafeMatcher

class ActionHelper {

    fun performClick(viewId: ViewInteraction) {
        try {
            viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())
            Logger.info("Performing Click", "Performed ClickedOn $viewId on the element")
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for click action: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during click action: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during click action: ${e.message}")
            throw e
        }
    }

    fun enterText(viewId: ViewInteraction, data: String) {
        try {
            viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.typeText(data))
            Logger.info("Enter text", "Entered text into $viewId with text - ${String}")
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for text entry: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during text entry: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during text entry: ${e.message}")
            throw e
        }
    }

    fun isElementVisibleOnScreen(viewId: ViewInteraction) {
        try {
            viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for visibility check: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during visibility check: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during visibility check: ${e.message}")
            throw e
        }
    }

    fun waitForView(viewId: ViewInteraction, timeout: Long) {
        val endTime = System.currentTimeMillis() + timeout
        while (System.currentTimeMillis() < endTime) {
            try {
                viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                Logger.info("Wait View", "wait for $timeout to load ")
                return
            } catch (e: NoMatchingViewException) {
                Logger.debug("Exception","No matching view for visibility check: ${e.message}")
                // Continue waiting
            } catch (e: AssertionFailedError) {
                Logger.debug("Exception","Assertion failed during visibility check: ${e.message}")
                // Continue waiting
            } catch (e: Exception) {
                Logger.debug("Exception","Unexpected error during visibility check: ${e.message}")
                throw e
            }
        }
        throw AssertionError("View with ID $viewId not loaded within $timeout ms")
    }

    fun clickOnElementWithIndex(viewId: ViewInteraction, index: Int) {
        try {
            viewId.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(index, click()))
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for RecyclerView item at position $index: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during RecyclerView item click: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during RecyclerView item click: ${e.message}")
            throw e
        }
    }

    fun scrollToElement(viewId: ViewInteraction) {
        try {
            viewId.perform(scrollTo())
            Logger.info("Scroll To Element", "Scroll to $viewId")
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for scroll action: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during scroll action: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during scroll action: ${e.message}")
            throw e
        }
    }


    // Method to extract the text from a TextView
    fun extractText(viewId: ViewInteraction): String {
        var extractedText = ""

        try {
            viewId.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(object : ViewAction {
                    override fun getConstraints(): Matcher<View> {
                        // Use the viewId directly to perform actions
                        return ViewMatchers.isDisplayed()
                    }

                    override fun getDescription(): String {
                        return "Extract text from TextView"
                    }

                    override fun perform(uiController: UiController?, view: View?) {
                        if (view is TextView) {
                            // Extract the text from the TextView
                            extractedText = view.text.toString()
                        } else {
                            // Throw an error if the view is not a TextView
                            throw AssertionError("View is not a TextView")
                        }
                    }
                })
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for extracting text: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during text extraction: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during text extraction: ${e.message}")
            throw e
        }

        return extractedText
    }
    fun verifyText(viewId: ViewInteraction, expectedText: String) {
        try {
            // Check if the view's text matches the expected text
            viewId.check(ViewAssertions.matches(ViewMatchers.withText(expectedText)))
            Logger.info("verify Text",expectedText)
        } catch (e: NoMatchingViewException) {
            Logger.debug("Exception","No matching view for text verification: ${e.message}")
            throw e
        } catch (e: AssertionFailedError) {
            Logger.debug("Exception","Assertion failed during text verification: ${e.message}")
            throw e
        } catch (e: Exception) {
            Logger.debug("Exception","Unexpected error during text verification: ${e.message}")
            throw e
        }
    }

    fun clickOnRecyclerViewItemWithText(viewId: ViewInteraction, textToFind: String) {
        try {
            viewId.perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(textToFind)),
                    ViewActions.click()
                )
            )
        } catch (e: Exception) {
            Logger.debug("Exception","Error clicking on RecyclerView item with text '$textToFind': ${e.message}")
            throw e
        }
    }
    fun extractTextFromRecyclerViewAtPosition(recyclerViewId: Int, position: Int,
                                              childrecyclerViewId: Int): String {
        try {
            var extractedText = ""

            // Scroll to the specific position in the RecyclerView
            onView(withId(recyclerViewId))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))

            // Perform an action on the item at the given position and extract the text
            onView(withId(recyclerViewId))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, ViewActions.scrollTo()))
                .check { view, _ ->
                    // Assuming the first child view at the position has the text you want to extract
                    // You can adjust this part if your layout is different
                    val textView = view.findViewById<TextView>(childrecyclerViewId) // Change this ID as per your layout
                    extractedText = textView.text.toString()  // Extract the text
                    Logger.debug("Extracted text", "Text at position $position: '$extractedText'")
                }

            return extractedText  // Return the extracted text
        } catch (e: Exception) {
            Logger.debug("Exception", "Error extracting text from RecyclerView at position $position: ${e.message}")
            throw e  // Rethrow the exception after logging it
        }
    }
    // extract the All texts from recyclerView List
    fun extractAllTextsFromRecyclerView(viewId: ViewInteraction, childViewId: Int): List<String> {
        val extractedTexts = mutableListOf<String>()

        try {
            // Find the total item count in the RecyclerView
            viewId.check { view, _ ->
                val recyclerView = view as RecyclerView
                val itemCount = recyclerView.adapter?.itemCount ?: 0

                for (position in 0 until itemCount) {
                    // Scroll to each position
                    viewId.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))

                    // Extract text from the child view
                    onView(
                        allOf(
                            withId(childViewId),
                            isDescendantOfA(nthChildOf(withId(recyclerView.id), position))
                        )
                    ).check { itemView, _ ->
                        val textView = itemView as TextView
                        extractedTexts.add(textView.text.toString())
                    }
                }
            }
        } catch (e: Exception) {
            Logger.e("ProductListPage", "Error extracting texts from RecyclerView", e)
        }

        return extractedTexts
    }
    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Nth child of parent")
            }

            override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (parent is ViewGroup && parentMatcher.matches(parent) && parent.getChildAt(childPosition) == view)
            }
        }
    }

    fun verifyTextWithContains(viewId: ViewInteraction, expectedText: String) {
        try {
            viewId
                .check(ViewAssertions.matches(hasDescendant(withText(containsString(expectedText)))))
        } catch (e: Exception) {
            Logger.e("ConstraintLayoutTest", "Error verifying large text in ConstraintLayout", e)
            throw e
        }
    }

    fun clickOnRemoveItem(titleText: String, removeItemText: String) {
        try {
            // Step 1: Find the title text inside InfoCL
            onView(withText(titleText))
                .check(matches(isDisplayed()))

            // Step 2: Traverse to the next sibling (AddToCartLL) and click "Remove Item"
            onView(allOf(
                withParent(isAssignableFrom(ConstraintLayout::class.java)),
                hasDescendant(withText(removeItemText))
            )).perform(click())


        } catch (e: Exception) {
            Logger.e("TraversalTest", "Error during sibling traversal and click", e)
        }
    }

    fun testScrollToItemWithText(viewId: ViewInteraction, visibleText:String) {
        // Scroll to the item with the text "Item 1"
        viewId
            .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText(visibleText))
            ))
    }

    fun ensureElementIsVisibleAndClick(viewId: ViewInteraction, textToFind: String) {
        try {
            // Ensure the RecyclerView item with text 'textToFind' is visible on screen and click it
            viewId.perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(textToFind)),
                    ViewActions.click()
                )
            )
        } catch (e: Exception) {
            Logger.debug("Exception", "Error performing action on RecyclerView item with text '$textToFind': ${e.message}")
            throw e
        }
    }

    fun isElementVisibleOnScreen(viewId: ViewInteraction, textToFind: String): Boolean {
        return try {
            // Perform the action to check if the item with the given text is visible on screen
            viewId.perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(textToFind))
                )
            )
            true  // The item is visible on the screen
        } catch (e: Exception) {
            false  // The item was not found or not visible
        }
    }

    fun clickOnButtonWithTextInRecyclerView(viewId: ViewInteraction, textToFind: String,buttonId: Int) {
        try {
            // Perform action to find the item containing the specified text (e.g., bag name) and the sibling Button
            viewId.perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText(textToFind))
                )
            )


            // Click the button within the scrolled item
            onView(allOf(
                withId(buttonId), isDisplayed()
                ))
            .perform(ViewActions.click())

        } catch (e: Exception) {
            Logger.debug("Exception", "Error clicking button for item with text '$textToFind': ${e.message}")
            throw e
        }
    }



    fun clickChildViewWithId(viewId: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(View::class.java)
            }

            override fun getDescription(): String {
                return "Click on a child view with ID: $viewId"
            }

            override fun perform(uiController: UiController, view: View) {
                val childView = view.findViewById<View>(viewId)
                childView.performClick()
            }
        }
    }







}

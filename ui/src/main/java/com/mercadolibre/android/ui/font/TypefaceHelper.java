package com.mercadolibre.android.ui.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * This class is used as a wrapper for our custom font.
 * If you code create a View that supports typeface you should call one of this methods.
 */
public final class TypefaceHelper {

    @NonNull
    private static TypefaceSetter typefaceSetter;

    static {
        typefaceSetter = new CalligraphyTypefaceSetter();
    }

    private TypefaceHelper() {
        //Do nothing, this class should not be instantiated
    }

    /**
     * Attach a typeface setter to this helper class
     * @param typefaceSetter field
     */
    public static void attachTypefaceSetter(@NonNull final TypefaceSetter typefaceSetter) {
        TypefaceHelper.typefaceSetter = typefaceSetter;
    }

    /**
     * Sets the typeface to the given {@link T}
     * @param <T>   A generic for the textview
     * @param view  The view to which apply the font
     * @param font  The {@link Font} the text should have
     */
    public static <T extends TextView> void setTypeface(@NonNull final T view, @NonNull final Font font) {
        typefaceSetter.setTypeface(view, font);
    }

    /**
     * Sets the typeface to the given {@link Paint}
     *
     * @param context A context to obtain the font
     * @param paint   The paint to which apply the font
     * @param font    The {@link Font} the text should have
     */
    public static void setTypeface(@NonNull final Context context, @NonNull final Paint paint, @NonNull final Font font) {
        typefaceSetter.setTypeface(context, paint, font);
    }

    /**
     * Get a tyoeface associated to the font passed.

     * @param context to use
     * @param font to use
     * @return associated typeface
     */
    public static Typeface geyFontTypeface(@NonNull final Context context, @NonNull Font font) {
        return typefaceSetter.getTypeface(context, font);
    }

    /**
     * Setter for typeface
     */
    public interface TypefaceSetter {

        /**
         * Set a typeface to a view
         * @param view to set the typeface to
         * @param font to set
         * @param <T> extends TextView
         */
        <T extends TextView> void setTypeface(@NonNull final T view, @NonNull final Font font);

        /**
         * Set a typeface to the paint
         * @param context to use
         * @param paint to set the typeface
         * @param font to set
         */
        void setTypeface(@NonNull final Context context, @NonNull final Paint paint, @NonNull final Font font);

        /**
         * Return the typeface associated with the font
         * @param context to use
         * @param font to find the typeface
         * @return typeface associated
         */
        Typeface getTypeface(@NonNull Context context, @NonNull final Font font);
    }
}

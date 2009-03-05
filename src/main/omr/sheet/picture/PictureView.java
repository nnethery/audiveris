//----------------------------------------------------------------------------//
//                                                                            //
//                           P i c t u r e V i e w                            //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2009. All rights reserved.               //
//  This software is released under the GNU General Public License.           //
//  Please contact users@audiveris.dev.java.net to report bugs & suggestions. //
//----------------------------------------------------------------------------//
//
package omr.sheet.picture;

import omr.log.Logger;

import omr.selection.SheetLocationEvent;

import omr.sheet.*;

import omr.ui.view.RubberPanel;
import omr.ui.view.ScrollView;

import java.awt.*;

/**
 * Class <code>PictureView</code> defines the view dedicated to the display of
 * the picture bitmap of a music sheet.
 *
 * @author Herv&eacute; Bitteur
 * @version $Id$
 */
public class PictureView
    extends ScrollView
{
    //~ Static fields/initializers ---------------------------------------------

    /** Usual logger utility */
    private static final Logger logger = Logger.getLogger(PictureView.class);

    //~ Instance fields --------------------------------------------------------

    /** Link with sheet */
    private final Sheet sheet;

    //~ Constructors -----------------------------------------------------------

    //-------------//
    // PictureView //
    //-------------//
    /**
     * Create a new <code>PictureView</code> instance, dedicated to a sheet.
     *
     * @param sheet the related sheet
     */
    public PictureView (Sheet sheet)
    {
        this.sheet = sheet;

        view = new MyView();
        view.setName("Picture-View");

        // Inject dependency of pixel location
        view.setLocationService(
            sheet.getSelectionService(),
            SheetLocationEvent.class);

        // Insert view
        setView(view);
    }

    //~ Inner Classes ----------------------------------------------------------

    //--------//
    // MyView //
    //--------//
    private class MyView
        extends RubberPanel
    {
        //~ Methods ------------------------------------------------------------

        //--------//
        // render //
        //--------//
        @Override
        public void render (Graphics g)
        {
            // Render the picture image
            sheet.getPicture()
                 .render(g);
        }
    }
}
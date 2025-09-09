package avanis.comunidad.portlet.portlet;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.portal.kernel.util.OrderByComparator;

public class MBMessageDateComparator extends OrderByComparator<MBMessage> {

    public static final String ORDER_BY_ASC = "MBMessage.createDate ASC";
    public static final String ORDER_BY_DESC = "MBMessage.createDate DESC";

    private final boolean _ascending;

    public MBMessageDateComparator() {
        this(false);
    }

    public MBMessageDateComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(MBMessage message1, MBMessage message2) {
        int value = message1.getCreateDate().compareTo(message2.getCreateDate());

        if (isAscending()) {
            return value;
        } else {
            return -value;
        }
    }

    @Override
    public String getOrderBy() {
        if (_ascending) {
            return ORDER_BY_ASC;
        } else {
            return ORDER_BY_DESC;
        }
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] { "createDate" };
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

}

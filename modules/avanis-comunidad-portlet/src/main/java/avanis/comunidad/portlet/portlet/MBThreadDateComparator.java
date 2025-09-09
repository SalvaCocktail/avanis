package avanis.comunidad.portlet.portlet;

import com.liferay.message.boards.model.MBThread;
import com.liferay.portal.kernel.util.OrderByComparator;

public class MBThreadDateComparator extends OrderByComparator<MBThread> {

    public static final String ORDER_BY_ASC = "MBThread.createDate ASC";
    public static final String ORDER_BY_DESC = "MBThread.createDate DESC";

    private final boolean _ascending;

    public MBThreadDateComparator() {
        this(false);
    }

    public MBThreadDateComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(MBThread thread1, MBThread thread2) {
        int value = thread1.getCreateDate().compareTo(thread2.getCreateDate());
        /*
        List<MBMessage> allMB = MBMessageLocalServiceUtil.getMBMessages(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        List<MBMessage> allMBMessage1 = new ArrayList<>();
        List<MBMessage> allMBMessage2 = new ArrayList<>();
        for (MBMessage mbMessage : allMB) {
            if(mbMessage.getRootMessageId() == thread1.getRootMessageId() && mbMessage.getMessageId() != thread1.getRootMessageId()) { allMBMessage1.add(mbMessage); }
            if(mbMessage.getRootMessageId() == thread2.getRootMessageId() && mbMessage.getMessageId() != thread2.getRootMessageId()) { allMBMessage2.add(mbMessage); }
        }
        Comparator<MBMessage> comparator = new MBMessageDateComparator(false);
        allMBMessage1.sort(comparator);
        allMBMessage2.sort(comparator);

        int value = -1;
        if(!allMBMessage1.isEmpty() && !allMBMessage2.isEmpty()) {
            value = allMBMessage1.get(0).getCreateDate().compareTo(allMBMessage2.get(0).getCreateDate());
        } else if (allMBMessage2.isEmpty()) {
            value = 1;
        }
        */

        if (isAscending()) {
            return value;
        } else {
            return -value;
        }
    }

    @Override
    public String getOrderBy() {
        if (isAscending()) {
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

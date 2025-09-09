package services.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;

import services.PrivatizeMessagesService;


@Component(service = PrivatizeMessagesService.class)
public class PrivatizeMessagesServiceImpl implements PrivatizeMessagesService {


    @Override
    public void privatizeMessages() {
        List<MBThread> threads = MBThreadLocalServiceUtil.getMBThreads(-1, -1);

        User adminUser = UserLocalServiceUtil.fetchUser(20122);


        for (MBThread thread : threads) {
            MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(thread.getRootMessageId());

            if (message == null) {
                System.out.println("***ERROR message " + thread.getRootMessageId() + " does not exist");
            } else {

                PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUser);

                try {
                    // Set the necessary thread locals
                    PrincipalThreadLocal.setName(adminUser.getUserId());
                    PermissionThreadLocal.setPermissionChecker(permissionChecker);

                    ExpandoBridge expandoBridge = message.getExpandoBridge();

                    expandoBridge.setAttribute("visibility", "registered");

                    System.out.println("***Visibility of messsage" + thread.getRootMessageId() + " updated");
                } catch (Exception e) {
                    System.out.println("***ERROR updating visibility of messsage" + thread.getRootMessageId());
                } finally {
                    // Clear the thread locals to avoid any potential issues
                    PrincipalThreadLocal.setName(null);
                    PermissionThreadLocal.setPermissionChecker(null);
                }
            }


        }


    }
}
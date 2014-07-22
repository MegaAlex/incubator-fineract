package org.mifosplatform.portfolio.group.handler;

import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.portfolio.group.service.GroupingTypesWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisassociateGroupsFromCenterCommandHandler implements NewCommandSourceHandler {

    private final GroupingTypesWritePlatformService writePlatformService;

    @Autowired
    public DisassociateGroupsFromCenterCommandHandler(final GroupingTypesWritePlatformService writePlatformService) {
        this.writePlatformService = writePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(JsonCommand command) {
        return this.writePlatformService.disassociateGroupsToCenter(command.entityId(), command);
    }

}

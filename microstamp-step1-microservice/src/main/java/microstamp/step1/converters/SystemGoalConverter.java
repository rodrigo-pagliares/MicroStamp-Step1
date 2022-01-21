package microstamp.step1.converters;

import microstamp.step1.data.SystemGoalEntity;
import microstamp.step1.dto.SystemGoalDto;

public class SystemGoalConverter {

    public static SystemGoalDto toDto(SystemGoalEntity target, Long externalId){
        boolean targetIsNull = target == null;

        String name = targetIsNull ? null : target.getName();
        Long projectId = targetIsNull ? null : externalId;

        return new SystemGoalDto(name,projectId);
    }

}

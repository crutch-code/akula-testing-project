package gcg.akula.service;

import gcg.akula.entity.dto.UserDto;
import gcg.akula.entity.dto.course.CourseDto;
import gcg.akula.entity.dto.course.UserCourseDto;
import gcg.akula.entity.request.MembershipRequest;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.BadRequestException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MembershipService {

    @Inject
    UserLessonService userLessonService;

    @Inject
    UserCourseService userCourseService;

    public ApplicationResponse<?> assignMembership(MembershipRequest target) throws BadRequestException {
        switch (target.getResourceType()){
            case 1 : return courseAssignation(target);
            default : throw new BadRequestException("Invalid resource type for membership assignation");
        }
    }

    public ApplicationResponse<?> courseAssignation(MembershipRequest request) throws BadRequestException {
        switch (request.getConsumerType()){
            case 1 ->{
                return ApplicationResponse.ok(
                        userCourseService.assignToCourse(
                                new UserCourseDto(
                                        null,
                                        new UserDto().setId(request.getConsumerId()),
                                        new CourseDto().setId(request.getResourceId())
                                )
                        )
                );
            }
            default -> throw new BadRequestException("Invalid consumer type for membership assignation");
        }
    }




}

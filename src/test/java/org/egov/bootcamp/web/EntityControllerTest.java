package org.egov.bootcamp.web;

import org.egov.bootcamp.model.Entity;
import org.egov.bootcamp.service.EntityService;
import org.egov.bootcamp.service.LogicService;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class EntityControllerTest {
    @Mock
    private EntityService entityService;

    @Mock
    private LogicService logicService;

    @InjectMocks
    private EntityController entityController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void entityIsNotNull() throws Exception {
        final Entity entity1 = new Entity(-100, "Ramesh");
        final Entity entity2 = new Entity(-200, "Suresh");
        final Entity entity3 = new Entity(-300, "Mahesh");
        final List<Entity> expectedEntities = Arrays.asList(entity1, entity2, entity3);
        when(entityService.get(anyInt())).thenAnswer(new Answer<Entity>() {
            public Entity answer(InvocationOnMock invocation) throws Throwable {
                Integer arg = (Integer) invocation.getArguments()[0];
                switch (arg) {
                    case 1:
                        return entity1;
                    case 2:
                        return entity2;
                    case 3:
                        return entity3;
                    default:
                        return null;

                }
            }
        });
        when(logicService.applyLogic(any(Entity.class))).thenAnswer(new Answer<Entity>() {
            public Entity answer(InvocationOnMock invocation) throws Throwable {
                return (Entity) invocation.getArguments()[0];
            }
        });
        final List<Integer> entityIds = Arrays.asList(1, 2, 3);
        List<Entity> actualEntity = entityController.get(entityIds);
        Matcher<Integer> matcher = new Matcher<Integer>() {
            public boolean matches(Object o) {
                return entityIds.contains(o);
            }

            public void describeMismatch(Object o, Description description) {

            }

            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }

            public void describeTo(Description description) {

            }
        };
        verify(entityService, times(3)).get(intThat(matcher));
        verify(logicService, times(3)).applyLogic(argThat(new Matcher<Entity>() {
            public boolean matches(Object o) {
                return expectedEntities.contains(o);
            }

            public void describeMismatch(Object o, Description description) {

            }

            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }

            public void describeTo(Description description) {

            }
        }));
        assertEquals(expectedEntities, actualEntity);
    }
}
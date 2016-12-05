package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.model.Entity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EntityServiceTest {
    @Mock
    private EntityDao entityDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(entityDao.get(Matchers.anyInt())).thenReturn(new Entity(1, "Yo"));
    }

    @Test
    public void shouldReturnTheExistingEntity() throws Exception {
        EntityService entityService = new EntityService(entityDao);
        Entity entity = entityService.get(1);
        assertNotNull(entity);
        assertEquals(Integer.valueOf(1), entity.getId());
        assertNotNull("Yo", entity.getName());
    }

    @Test
    public void shouldReturnTheExistingEntityReflection() throws Exception {
        EntityService entityService = new EntityService();
        Whitebox.setInternalState(entityService, "entityDao", entityDao);
        Entity entity = entityService.get(1);
        assertNotNull(entity);
        assertEquals(Integer.valueOf(1), entity.getId());
        assertNotNull("Yo", entity.getName());
    }


}
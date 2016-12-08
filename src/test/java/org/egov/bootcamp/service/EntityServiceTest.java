package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.model.Entity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EntityServiceTest {
    @Mock
    private EntityDao entityDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(entityDao.get(5)).thenReturn(new Entity(5, "Yo"));
    }

    @Test
    public void shouldReturnTheExistingEntity() throws Exception {
        EntityService entityService = new EntityService(entityDao);
        Entity entity = entityService.get(5);
        assertNotNull(entity);
        assertEquals(Integer.valueOf(5), entity.getId());
        assertEquals("Entity Yo", entity.getName());
        assertEquals("YO", entity.getCapName());
        Mockito.verify(entityDao, times(1)).get(5);
    }
}
package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.egov.bootcamp.model.Entity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EntityServiceTest {
    @Mock
    private EntityDao entityDao;

    @InjectMocks
    private EntityService entityService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void happyPath() throws Exception {
        when(entityDao.get(any(Integer.class))).thenReturn(new Entity(1, "Name"));
        Entity entity = entityService.get(1);
        assertNotNull(entity);
        assertEquals(Integer.valueOf(1), entity.getId());
        assertEquals("Entity Name", entity.getName());
        assertEquals("NAME", entity.getCapName());
        verify(entityDao).get(2);
    }
}
// Copyright 2007, 2008 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.internal.hibernate;

import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.hibernate.HibernateConstants;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.hibernate.cfg.Configuration;

/**
 * Simply calls configure() to do the default Hibernate configuration.  This will read the hibernate.cfg.xml file.
 */
public final class DefaultHibernateConfigurer implements HibernateConfigurer
{
    private final boolean defaultConfiguration;

    public DefaultHibernateConfigurer(
            @Symbol(HibernateConstants.DEFAULT_CONFIGURATION)
            boolean defaultConfiguration)
    {
        this.defaultConfiguration = defaultConfiguration;
    }

    public void configure(Configuration configuration)
    {
        if (defaultConfiguration) configuration.configure();
    }
}

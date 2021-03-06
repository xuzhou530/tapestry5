// Copyright 2006, 2007, 2008 The Apache Software Foundation
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

package org.apache.tapestry5.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.UsesMappedConfiguration;
import org.apache.tapestry5.ioc.services.ThreadLocale;

import java.util.Locale;

/**
 * Used to find or create an {@link org.apache.tapestry5.Asset} with a given path.
 * <p/>
 * Assets are defined with a domain, and the domain is indicated by a prefix.  The two builtin domains are "context:"
 * (for files inside the web application context) and "classpath:" for files stored on the classpath (typically, inside
 * a JAR, such as a component library).
 */
@UsesMappedConfiguration(AssetFactory.class)
public interface AssetSource
{
    /**
     * Finds the asset. The path may either be a simple file name or a relative path (relative to the base resource)
     * <em>or</em> it may have a prefix, such as "context:" or "classpath:", in which case it is treated as a complete
     * path within the indicated domain. The resulting Resource is then localized (to the provided Locale) and returned
     * as an Asset.
     * <p/>
     * The AssetSource caches its results, so a single Asset instance may be shared among many different components.
     *
     * @param baseResource base resource for computing relative paths, or null to search the classpath
     * @param path         relative to the base resource
     * @param locale       locale to localize the final resource to, or null for the thread's current locale
     * @return the asset
     * @throws RuntimeException if the asset can not be found
     */
    Asset getAsset(Resource baseResource, String path, Locale locale);

    /**
     * Convienience for finding assets on the classpath.
     *
     * @param path   path to the base resource, relative to classpath root
     * @param locale to localize the resource to
     * @return the asset
     */
    Asset getClasspathAsset(String path, Locale locale);

    /**
     * Obtains a classpath alias in the current locale (as defined by the {@link ThreadLocale} service).
     *
     * @param path
     * @return the asset
     */
    Asset getClasspathAsset(String path);
}
